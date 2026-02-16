package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import com.genoma.plus.dao.historia.MaltratoViolenciaDAO;
import com.genoma.plus.dao.impl.historia.MaltratoViolenciaDAOImpl;
import com.genoma.plus.dto.historia.MaltratoViolenciaDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPMaltratoViolencia.class */
public class JPMaltratoViolencia extends JPanel {
    private MaltratoViolenciaDAO xMaltratoViolenciaDAO;
    private clasesHistoriaCE xclase;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    public JDateChooser JDFecha;
    private JLabel JLNo;
    private JPanel JPDatos;
    private JRadioButton JRBNo1;
    private JRadioButton JRBNo2;
    private JRadioButton JRBNo3;
    private JRadioButton JRBNo4;
    private JRadioButton JRBSi1;
    private JRadioButton JRBSi2;
    private JRadioButton JRBSi3;
    private JRadioButton JRBSi4;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObserE;
    private JScrollPane JSPObserE1;
    private JScrollPane JSPObserE2;
    private JScrollPane JSPObserE3;
    private JTextArea JTAObservacion1;
    private JTextArea JTAObservacion2;
    private JTextArea JTAObservacion3;
    private JTextArea JTAObservacion4;
    private JTable JTHistorico;
    private JTabbedPane JTPGeneral;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup4;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private int xAprobado = 0;
    private Metodos xmetodo = new Metodos();
    private int xP1 = 0;
    private int xP2 = 0;
    private int xP3 = 0;
    private int xP4 = 0;

    public JPMaltratoViolencia(clasesHistoriaCE xclase) {
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTAObservacion1);
        SpellChecker.register(this.JTAObservacion2);
        SpellChecker.register(this.JTAObservacion3);
        SpellChecker.register(this.JTAObservacion4);
        springStart();
        this.xclase = xclase;
        mNuevo();
    }

    private void springStart() {
        this.xMaltratoViolenciaDAO = (MaltratoViolenciaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("maltratoViolenciaDAO");
    }

    public void mNuevo() {
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JRBNo1.setSelected(true);
        this.xP1 = 0;
        this.JTAObservacion1.setText("");
        this.JRBNo2.setSelected(true);
        this.xP2 = 0;
        this.JTAObservacion2.setText("");
        this.JRBNo3.setSelected(true);
        this.xP3 = 0;
        this.JTAObservacion3.setText("");
        this.xP4 = 0;
        this.JTAObservacion4.setText("");
        mCargarDatosTabla();
        mVerificarAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
    }

    private void mVerificarAtencion(String xidAtencion) {
        for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
            if (this.xmodelo.getValueAt(x, 1).toString().equals(xidAtencion)) {
                this.JTHistorico.changeSelection(x, 0, false, false);
                JTHistoricoMouseClicked(null);
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
        }
    }

    public void mGrabar() {
        if (this.JLNo.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                MaltratoViolenciaDTO xMaltrato = new MaltratoViolenciaDTO();
                xMaltrato.setIdAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                xMaltrato.setFecha(this.xmetodo.formatoAMD1.format(this.JDFecha.getDate()));
                xMaltrato.setP1(this.xP1);
                xMaltrato.setDetalleP1(this.JTAObservacion1.getText());
                xMaltrato.setP2(this.xP2);
                xMaltrato.setDetalleP2(this.JTAObservacion2.getText());
                xMaltrato.setP3(this.xP3);
                xMaltrato.setDetalleP3(this.JTAObservacion3.getText());
                xMaltrato.setP4(this.xP4);
                xMaltrato.setDetalleP4(this.JTAObservacion4.getText());
                xMaltrato.setIdEspecialidad(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()));
                xMaltrato.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                this.JLNo.setText(this.xMaltratoViolenciaDAO.create_return_id(xMaltrato));
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            mCargarDatosTabla();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este registro ya se encuentra grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No. Atencion", "Fecha", "P1", "Obs1", "P2", "Obs2", "P3", "Obs3", "P4", "Obs4", "Profesional", "Especialidad"}) { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.1
            Class[] types = {Long.class, Long.class, String.class, Boolean.class, String.class, Boolean.class, String.class, Boolean.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(12).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        List<MaltratoViolenciaDTO> list = this.xMaltratoViolenciaDAO.listMaltrato(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIdAtencion(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getFecha(), x, 2);
            if (list.get(x).getP1() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
            this.xmodelo.setValueAt(list.get(x).getDetalleP1(), x, 4);
            if (list.get(x).getP2() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
            this.xmodelo.setValueAt(list.get(x).getDetalleP2(), x, 6);
            if (list.get(x).getP3() == 1) {
                this.xmodelo.setValueAt(true, x, 7);
            } else {
                this.xmodelo.setValueAt(false, x, 7);
            }
            this.xmodelo.setValueAt(list.get(x).getDetalleP3(), x, 8);
            if (list.get(x).getP4() == 1) {
                this.xmodelo.setValueAt(true, x, 9);
            } else {
                this.xmodelo.setValueAt(false, x, 9);
            }
            this.xmodelo.setValueAt(list.get(x).getDetalleP4(), x, 10);
            this.xmodelo.setValueAt(list.get(x).getIdProfesional(), x, 11);
            this.xmodelo.setValueAt(list.get(x).getIdEspecialidad(), x, 12);
        }
    }

    /* JADX WARN: Type inference failed for: r3v82, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.buttonGroup4 = new ButtonGroup();
        this.JTPGeneral = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JSPObserE = new JScrollPane();
        this.JTAObservacion3 = new JTextArea();
        this.JLNo = new JLabel();
        this.JDFecha = new JDateChooser();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.JSPObserE1 = new JScrollPane();
        this.JTAObservacion1 = new JTextArea();
        this.jLabel6 = new JLabel();
        this.JSPObserE2 = new JScrollPane();
        this.JTAObservacion2 = new JTextArea();
        this.JRBSi1 = new JRadioButton();
        this.JRBNo1 = new JRadioButton();
        this.JRBSi2 = new JRadioButton();
        this.JRBNo2 = new JRadioButton();
        this.JRBSi3 = new JRadioButton();
        this.JRBNo3 = new JRadioButton();
        this.JSPObserE3 = new JScrollPane();
        this.JTAObservacion4 = new JTextArea();
        this.jLabel7 = new JLabel();
        this.JRBSi4 = new JRadioButton();
        this.JRBNo4 = new JRadioButton();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpmaltratoviolencia");
        this.JTPGeneral.setForeground(new Color(0, 103, 0));
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JTAObservacion3.setColumns(1);
        this.JTAObservacion3.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion3.setLineWrap(true);
        this.JTAObservacion3.setRows(1);
        this.JTAObservacion3.setTabSize(1);
        this.JTAObservacion3.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE.setViewportView(this.JTAObservacion3);
        this.JLNo.setFont(new Font("Arial", 1, 12));
        this.JLNo.setForeground(Color.red);
        this.JLNo.setHorizontalAlignment(0);
        this.JLNo.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPMaltratoViolencia.this.JDFechaPropertyChange(evt);
            }
        });
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setHorizontalAlignment(2);
        this.jLabel4.setText("¿DURANTE EL ÚLTIMO AÑO, ha sido humillada, menospreciada, insultada, o amenazada por su pareja?");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setHorizontalAlignment(2);
        this.jLabel5.setText("¿DURANTE EL ÚLTIMO AÑO, fue golpeada, bofeteada, pateada, o lastimada físicamente de otra manera?");
        this.JTAObservacion1.setColumns(1);
        this.JTAObservacion1.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion1.setLineWrap(true);
        this.JTAObservacion1.setRows(1);
        this.JTAObservacion1.setTabSize(1);
        this.JTAObservacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE1.setViewportView(this.JTAObservacion1);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setHorizontalAlignment(2);
        this.jLabel6.setText("¿DESDE QUE ESTÁ EMBARAZADA, ha sido golpeada, bofeteada, pateada, o lastimada físicamente de alguna manera?");
        this.JTAObservacion2.setColumns(1);
        this.JTAObservacion2.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion2.setLineWrap(true);
        this.JTAObservacion2.setRows(1);
        this.JTAObservacion2.setTabSize(1);
        this.JTAObservacion2.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE2.setViewportView(this.JTAObservacion2);
        this.buttonGroup1.add(this.JRBSi1);
        this.JRBSi1.setFont(new Font("Arial", 1, 12));
        this.JRBSi1.setText("SI");
        this.JRBSi1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.3
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBSi1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBNo1);
        this.JRBNo1.setFont(new Font("Arial", 1, 12));
        this.JRBNo1.setSelected(true);
        this.JRBNo1.setText("NO");
        this.JRBNo1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.4
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBNo1ActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBSi2);
        this.JRBSi2.setFont(new Font("Arial", 1, 12));
        this.JRBSi2.setText("SI");
        this.JRBSi2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.5
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBSi2ActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBNo2);
        this.JRBNo2.setFont(new Font("Arial", 1, 12));
        this.JRBNo2.setSelected(true);
        this.JRBNo2.setText("NO");
        this.JRBNo2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.6
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBNo2ActionPerformed(evt);
            }
        });
        this.buttonGroup3.add(this.JRBSi3);
        this.JRBSi3.setFont(new Font("Arial", 1, 12));
        this.JRBSi3.setText("SI");
        this.JRBSi3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.7
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBSi3ActionPerformed(evt);
            }
        });
        this.buttonGroup3.add(this.JRBNo3);
        this.JRBNo3.setFont(new Font("Arial", 1, 12));
        this.JRBNo3.setSelected(true);
        this.JRBNo3.setText("NO");
        this.JRBNo3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.8
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBNo3ActionPerformed(evt);
            }
        });
        this.JTAObservacion4.setColumns(1);
        this.JTAObservacion4.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion4.setLineWrap(true);
        this.JTAObservacion4.setRows(1);
        this.JTAObservacion4.setTabSize(1);
        this.JTAObservacion4.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE3.setViewportView(this.JTAObservacion4);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setHorizontalAlignment(2);
        this.jLabel7.setText("¿DESDE QUE ESTÁ EMBARAZADA, ha sido golpeada, bofeteada, pateada, o lastimada físicamente de alguna manera?");
        this.buttonGroup4.add(this.JRBSi4);
        this.JRBSi4.setFont(new Font("Arial", 1, 12));
        this.JRBSi4.setText("SI");
        this.JRBSi4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.9
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBSi4ActionPerformed(evt);
            }
        });
        this.buttonGroup4.add(this.JRBNo4);
        this.JRBNo4.setFont(new Font("Arial", 1, 12));
        this.JRBNo4.setSelected(true);
        this.JRBNo4.setText("NO");
        this.JRBNo4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.10
            public void actionPerformed(ActionEvent evt) {
                JPMaltratoViolencia.this.JRBNo4ActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jLabel6).addGap(54, 54, 54).addComponent(this.JRBSi3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo3)).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObserE3).addComponent(this.JSPObserE).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jLabel5, -2, 657, -2).addGap(54, 54, 54).addComponent(this.JRBSi2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo2, -2, 45, -2)).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPObserE2, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JDFecha, -2, 131, -2)).addComponent(this.jLabel4, -2, 657, -2)).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(53, 53, 53).addComponent(this.JRBSi1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo1)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLNo, -2, 121, -2).addGap(25, 25, 25)))).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addComponent(this.jLabel7).addGap(56, 56, 56).addComponent(this.JRBSi4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo4)).addComponent(this.JSPObserE1, GroupLayout.Alignment.LEADING))))).addGap(10, 10, 10)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, 50, -2).addComponent(this.JLNo, -2, 50, -2)).addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -2, 50, -2).addComponent(this.JRBSi1).addComponent(this.JRBNo1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObserE1, -2, 66, -2).addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi2).addComponent(this.JRBNo2).addComponent(this.jLabel5, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObserE2, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6, -2, 50, -2).addComponent(this.JRBNo3).addComponent(this.JRBSi3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObserE, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7, -2, 50, -2).addComponent(this.JRBNo4).addComponent(this.JRBSi4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObserE3, -2, 66, -2)));
        this.JTPGeneral.addTab("INFORMACION", this.JPDatos);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPMaltratoViolencia.11
            public void mouseClicked(MouseEvent evt) {
                JPMaltratoViolencia.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JTPGeneral.addTab("HISTÓRICO", this.JSPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral, -2, 868, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral, -2, 621, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi1ActionPerformed(ActionEvent evt) {
        this.xP1 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo1ActionPerformed(ActionEvent evt) {
        this.xP1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi2ActionPerformed(ActionEvent evt) {
        this.xP2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo2ActionPerformed(ActionEvent evt) {
        this.xP2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi3ActionPerformed(ActionEvent evt) {
        this.xP3 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo3ActionPerformed(ActionEvent evt) {
        this.xP3 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JLNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JDFecha.setDate(Date.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JRBSi1.setSelected(true);
                this.xP1 = 1;
            } else {
                this.JRBSi1.setSelected(false);
                this.xP1 = 0;
            }
            this.JTAObservacion1.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()).booleanValue()) {
                this.JRBSi2.setSelected(true);
                this.xP2 = 1;
            } else {
                this.JRBSi2.setSelected(false);
                this.xP2 = 0;
            }
            this.JTAObservacion2.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString()).booleanValue()) {
                this.JRBSi3.setSelected(true);
                this.xP3 = 1;
            } else {
                this.JRBSi3.setSelected(false);
                this.xP3 = 0;
            }
            this.JTAObservacion3.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 9).toString()).booleanValue()) {
                this.JRBSi4.setSelected(true);
                this.xP4 = 1;
            } else {
                this.JRBSi4.setSelected(false);
                this.xP4 = 0;
            }
            this.JTAObservacion4.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 10).toString());
            this.JTPGeneral.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi4ActionPerformed(ActionEvent evt) {
        this.xP4 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo4ActionPerformed(ActionEvent evt) {
        this.xP4 = 0;
    }
}
