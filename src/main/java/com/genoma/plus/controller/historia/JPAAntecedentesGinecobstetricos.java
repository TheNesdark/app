package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO;
import com.genoma.plus.dao.impl.historia.AntecedentesGinecobstetricosDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AntecedentesGinecobstetricosDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAAntecedentesGinecobstetricos.class */
public class JPAAntecedentesGinecobstetricos extends JPanel {
    private final clasesHistoriaCE xClaseHC;
    private AntecedentesGinecobstetricosDAO xAntecedentesGinecobstetricosDAO;
    private final AntecedentesGinecobstetricosDTO xAntecedentesGinecobstetricosDTO = new AntecedentesGinecobstetricosDTO();
    private int enfMama = 0;
    private int xtipo = 0;
    private int xidcitologia = 0;
    private int xGemelar = -1;
    public String xidpersona = "0";
    private final Metodos metodos = new Metodos();
    private String[] xIdMetPlanificar;
    private JCheckBox JCHEmbarazada;
    private JCheckBox JCHEmbarazada1;
    private JCheckBox JCHRealizado;
    private JScrollPane JSPDRMamas;
    private JTextField JTFCiclo;
    private JTextField JTFFechaPParto;
    private JTextField JTFFechaUAborto;
    private JTextField JTFFechaUBiopsia;
    private JTextField JTFFechaUCitologia;
    private JTextField JTFFechaUConizacionCU;
    private JTextField JTFFechaUCuelloU;
    private JTextField JTFFechaUEcografia;
    private JTextField JTFFechaUHisterectomia;
    private JTextField JTFFechaULegrado;
    private JTextField JTFFechaUMestruacion;
    private JTextField JTFFechaUParto;
    private JTextField JTFFechaURadioTerapia;
    private JTextField JTFSemanaG;
    private JCheckBox btnEnfMama;
    public JDateChooser cboFechaPParto;
    private JComboBox cboMetodo;
    public JDateChooser cboUltimaAborto;
    public JDateChooser cboUltimaCitologia;
    public JDateChooser cboUltimaLegrado;
    public JDateChooser cboUltimaMestruacion;
    private JButton jbtnGuardar;
    private JButton jbtnNuevo;
    private JPanel jpGinecologico;
    private JPanel jpObstetrico;
    private JPanel jpQuirurgico;
    public JDateChooser txtBiopsia;
    public JDateChooser txtCauterizacion;
    public JDateChooser txtConizacion;
    private JSpinner txtEdadRelaciones;
    public JDateChooser txtHisterectomia;
    private JTextField txtMenarquia;
    private JSpinner txtNoAbortos;
    private JSpinner txtNoCesareas;
    private JSpinner txtNoEmbarazos;
    private JSpinner txtNoEptopicos;
    private JSpinner txtNoMuertos;
    private JSpinner txtNoPartos;
    private JSpinner txtNoVivos;
    public JDateChooser txtRadioterapia;
    private JTextPane txtResultadoMamas;
    private JSpinner txtTiempoPlanifica;
    public JDateChooser txtUltimaEco;
    public JDateChooser txtUltimoParto;

    public JPAAntecedentesGinecobstetricos(clasesHistoriaCE xClaseHC) {
        initComponents();
        springStart();
        this.xClaseHC = xClaseHC;
        mCargarDatos();
    }

    private void springStart() {
        this.xAntecedentesGinecobstetricosDAO = (AntecedentesGinecobstetricosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("antecedentesGinecoobstetricoDAO");
    }

    public void mNuevo() {
        mCargarComboMetPlanificar();
        limpiarCampos(this.jpQuirurgico);
        limpiarCampos(this.jpGinecologico);
        limpiarCampos(this.jpObstetrico);
    }

    public void limpiarCampos(JPanel jp) {
        for (int x = 0; x < jp.getComponentCount(); x++) {
            if (jp.getComponent(x).getClass().toString().equals("class javax.swing.JTextField")) {
                JTextField jtf = jp.getComponent(x);
                jtf.setText("");
            }
            if (jp.getComponent(x).getClass().toString().equals("class javax.swing.JSpinner")) {
                JSpinner jsp = jp.getComponent(x);
                jsp.setValue(0);
            }
            if (jp.getComponent(x).getClass().toString().equals("class javax.swing.JComboBox")) {
                JComboBox jcb = jp.getComponent(x);
                jcb.setSelectedIndex(-1);
            }
            if (jp.getComponent(x).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox jckb = jp.getComponent(x);
                jckb.setSelected(true);
            }
        }
    }

    private void initComponents() {
        this.jpObstetrico = new JPanel();
        this.txtNoEmbarazos = new JSpinner();
        this.txtNoAbortos = new JSpinner();
        this.txtNoPartos = new JSpinner();
        this.txtNoCesareas = new JSpinner();
        this.txtNoEptopicos = new JSpinner();
        this.txtNoMuertos = new JSpinner();
        this.txtNoVivos = new JSpinner();
        this.JTFFechaUParto = new JTextField();
        this.JTFFechaUAborto = new JTextField();
        this.JTFFechaUMestruacion = new JTextField();
        this.cboUltimaMestruacion = new JDateChooser();
        this.txtUltimoParto = new JDateChooser();
        this.cboUltimaAborto = new JDateChooser();
        this.JTFFechaULegrado = new JTextField();
        this.cboUltimaLegrado = new JDateChooser();
        this.JTFFechaPParto = new JTextField();
        this.cboFechaPParto = new JDateChooser();
        this.JTFSemanaG = new JTextField();
        this.JCHEmbarazada = new JCheckBox();
        this.JCHEmbarazada1 = new JCheckBox();
        this.jpGinecologico = new JPanel();
        this.JTFFechaUEcografia = new JTextField();
        this.btnEnfMama = new JCheckBox();
        this.JSPDRMamas = new JScrollPane();
        this.txtResultadoMamas = new JTextPane();
        this.txtEdadRelaciones = new JSpinner();
        this.txtTiempoPlanifica = new JSpinner();
        this.cboMetodo = new JComboBox();
        this.JTFCiclo = new JTextField();
        this.JTFFechaUCitologia = new JTextField();
        this.JCHRealizado = new JCheckBox();
        this.txtUltimaEco = new JDateChooser();
        this.cboUltimaCitologia = new JDateChooser();
        this.txtMenarquia = new JTextField();
        this.jbtnGuardar = new JButton();
        this.jpQuirurgico = new JPanel();
        this.txtCauterizacion = new JDateChooser();
        this.txtRadioterapia = new JDateChooser();
        this.txtHisterectomia = new JDateChooser();
        this.txtConizacion = new JDateChooser();
        this.txtBiopsia = new JDateChooser();
        this.JTFFechaUCuelloU = new JTextField();
        this.JTFFechaURadioTerapia = new JTextField();
        this.JTFFechaUHisterectomia = new JTextField();
        this.JTFFechaUConizacionCU = new JTextField();
        this.JTFFechaUBiopsia = new JTextField();
        this.jbtnNuevo = new JButton();
        this.jpObstetrico.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "OBSTÉTRICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtNoEmbarazos.setFont(new Font("Arial", 1, 12));
        this.txtNoEmbarazos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoEmbarazos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Embarazo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoEmbarazos.setMinimumSize(new Dimension(44, 60));
        this.txtNoEmbarazos.setPreferredSize(new Dimension(44, 60));
        this.txtNoAbortos.setFont(new Font("Arial", 1, 12));
        this.txtNoAbortos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoAbortos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Abortos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPartos.setFont(new Font("Arial", 1, 12));
        this.txtNoPartos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoPartos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Partos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoCesareas.setFont(new Font("Arial", 1, 12));
        this.txtNoCesareas.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoCesareas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cesareas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoEptopicos.setFont(new Font("Arial", 1, 12));
        this.txtNoEptopicos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoEptopicos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Ectopicos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoMuertos.setFont(new Font("Arial", 1, 12));
        this.txtNoMuertos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoMuertos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nac Muertos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoVivos.setFont(new Font("Arial", 1, 12));
        this.txtNoVivos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoVivos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nac Vivos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUParto.setHorizontalAlignment(4);
        this.JTFFechaUParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUAborto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUAborto.setHorizontalAlignment(4);
        this.JTFFechaUAborto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Aborto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUMestruacion.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUMestruacion.setHorizontalAlignment(4);
        this.JTFFechaUMestruacion.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Mestruación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaMestruacion.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaMestruacion.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaMestruacion.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaMestruacion.setName("cboMenarquia");
        this.cboUltimaMestruacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.cboUltimaMestruacionPropertyChange(evt);
            }
        });
        this.txtUltimoParto.setDateFormatString("dd/MM/yyyy");
        this.txtUltimoParto.setFont(new Font("Tahoma", 1, 12));
        this.txtUltimoParto.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimoParto.setName("cboMenarquia");
        this.txtUltimoParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtUltimoPartoPropertyChange(evt);
            }
        });
        this.cboUltimaAborto.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaAborto.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaAborto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaAborto.setName("cboMenarquia");
        this.cboUltimaAborto.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.cboUltimaAbortoPropertyChange(evt);
            }
        });
        this.JTFFechaULegrado.setFont(new Font("Arial", 1, 12));
        this.JTFFechaULegrado.setHorizontalAlignment(4);
        this.JTFFechaULegrado.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Legrado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaLegrado.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaLegrado.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaLegrado.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaLegrado.setName("cboMenarquia");
        this.cboUltimaLegrado.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.cboUltimaLegradoPropertyChange(evt);
            }
        });
        this.JTFFechaPParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaPParto.setHorizontalAlignment(4);
        this.JTFFechaPParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FPP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboFechaPParto.setDateFormatString("dd/MM/yyyy");
        this.cboFechaPParto.setFont(new Font("Tahoma", 1, 12));
        this.cboFechaPParto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboFechaPParto.setName("cboMenarquia");
        this.cboFechaPParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.cboFechaPPartoPropertyChange(evt);
            }
        });
        this.JTFSemanaG.setFont(new Font("Arial", 1, 12));
        this.JTFSemanaG.setHorizontalAlignment(4);
        this.JTFSemanaG.setBorder(BorderFactory.createTitledBorder((Border) null, "Semana Gestaciòn", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEmbarazada.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada.setText("Actualmente esta embarazada?");
        this.JCHEmbarazada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.6
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesGinecobstetricos.this.JCHEmbarazadaActionPerformed(evt);
            }
        });
        this.JCHEmbarazada1.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada1.setText("Embarazo Gemelar?");
        this.JCHEmbarazada1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.7
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesGinecobstetricos.this.JCHEmbarazada1ActionPerformed(evt);
            }
        });
        GroupLayout jpObstetricoLayout = new GroupLayout(this.jpObstetrico);
        this.jpObstetrico.setLayout(jpObstetricoLayout);
        jpObstetricoLayout.setHorizontalGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObstetricoLayout.createSequentialGroup().addContainerGap().addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObstetricoLayout.createSequentialGroup().addComponent(this.JTFSemanaG, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEmbarazada).addComponent(this.JCHEmbarazada1))).addGroup(jpObstetricoLayout.createSequentialGroup().addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObstetricoLayout.createSequentialGroup().addComponent(this.txtNoEmbarazos, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoAbortos, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoPartos, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoCesareas, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoEptopicos, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoMuertos, -2, 119, -2)).addGroup(jpObstetricoLayout.createSequentialGroup().addComponent(this.JTFFechaUParto, -2, 115, -2).addGap(0, 0, 0).addComponent(this.txtUltimoParto, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaUAborto, -2, 115, -2).addGap(0, 0, 0).addComponent(this.cboUltimaAborto, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaUMestruacion, -2, 115, -2).addGap(0, 0, 0).addComponent(this.cboUltimaMestruacion, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaULegrado, -2, 115, -2).addGap(0, 0, 0).addComponent(this.cboUltimaLegrado, -2, 24, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaPParto, -2, 115, -2))).addGap(0, 0, 0).addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboFechaPParto, -2, 20, -2).addComponent(this.txtNoVivos, -2, 110, -2)))).addContainerGap(27, 32767)));
        jpObstetricoLayout.setVerticalGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jpObstetricoLayout.createSequentialGroup().addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.txtNoEmbarazos, -2, 50, -2).addComponent(this.txtNoAbortos, -2, 50, -2).addComponent(this.txtNoPartos, -2, 50, -2).addComponent(this.txtNoCesareas, -2, 50, -2).addComponent(this.txtNoEptopicos, -2, 50, -2).addComponent(this.txtNoMuertos, -2, 50, -2).addComponent(this.txtNoVivos, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtUltimoParto, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JTFFechaUParto, -2, 50, -2)).addComponent(this.JTFFechaUAborto, -2, 50, -2).addComponent(this.cboUltimaAborto, -2, 50, -2).addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUMestruacion, -2, 50, -2).addComponent(this.cboUltimaMestruacion, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaULegrado, -2, 50, -2).addComponent(this.cboUltimaLegrado, -2, 50, -2))).addComponent(this.JTFFechaPParto, -2, 50, -2).addComponent(this.cboFechaPParto, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jpObstetricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFSemanaG, -2, 50, -2).addGroup(jpObstetricoLayout.createSequentialGroup().addComponent(this.JCHEmbarazada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEmbarazada1)))));
        this.jpGinecologico.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(255, 255, 255), (Color) null), "GINECOLÓGICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFechaUEcografia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUEcografia.setHorizontalAlignment(4);
        this.JTFFechaUEcografia.setBorder(BorderFactory.createTitledBorder((Border) null, "FUEcografia Mama", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnEnfMama.setFont(new Font("Arial", 1, 12));
        this.btnEnfMama.setForeground(Color.blue);
        this.btnEnfMama.setText("Enf. Mama?");
        this.btnEnfMama.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesGinecobstetricos.this.btnEnfMamaActionPerformed(evt);
            }
        });
        this.JSPDRMamas.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción Enfermedad Mamas", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtResultadoMamas.setFont(new Font("Arial", 1, 12));
        this.txtResultadoMamas.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.9
            public void keyPressed(KeyEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtResultadoMamasKeyPressed(evt);
            }
        });
        this.JSPDRMamas.setViewportView(this.txtResultadoMamas);
        this.txtEdadRelaciones.setFont(new Font("Arial", 1, 12));
        this.txtEdadRelaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad IRelaciones (Años)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTiempoPlanifica.setFont(new Font("Arial", 1, 12));
        this.txtTiempoPlanifica.setBorder(BorderFactory.createTitledBorder((Border) null, "T.Planificación (Meses)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboMetodo.setFont(new Font("Arial", 1, 12));
        this.cboMetodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Método de Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCiclo.setFont(new Font("Arial", 1, 12));
        this.JTFCiclo.setHorizontalAlignment(4);
        this.JTFCiclo.setBorder(BorderFactory.createTitledBorder((Border) null, "Ciclos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUCitologia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUCitologia.setHorizontalAlignment(4);
        this.JTFFechaUCitologia.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Citologia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHRealizado.setFont(new Font("Arial", 1, 12));
        this.JCHRealizado.setText("Sin Realizar");
        this.JCHRealizado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.10
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesGinecobstetricos.this.JCHRealizadoActionPerformed(evt);
            }
        });
        this.txtUltimaEco.setDateFormatString("dd/MM/yyyy");
        this.txtUltimaEco.setFont(new Font("Tahoma", 1, 12));
        this.txtUltimaEco.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimaEco.setName("cboMenarquia");
        this.txtUltimaEco.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.11
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtUltimaEcoPropertyChange(evt);
            }
        });
        this.cboUltimaCitologia.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaCitologia.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaCitologia.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaCitologia.setName("cboMenarquia");
        this.cboUltimaCitologia.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.cboUltimaCitologiaPropertyChange(evt);
            }
        });
        this.txtMenarquia.setFont(new Font("Arial", 1, 12));
        this.txtMenarquia.setHorizontalAlignment(4);
        this.txtMenarquia.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Menarquia (Años)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jpGinecologicoLayout = new GroupLayout(this.jpGinecologico);
        this.jpGinecologico.setLayout(jpGinecologicoLayout);
        jpGinecologicoLayout.setHorizontalGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpGinecologicoLayout.createSequentialGroup().addContainerGap().addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpGinecologicoLayout.createSequentialGroup().addComponent(this.txtMenarquia, -2, 173, -2).addContainerGap(-1, 32767)).addGroup(jpGinecologicoLayout.createSequentialGroup().addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtEdadRelaciones, -1, 166, 32767).addComponent(this.JTFCiclo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpGinecologicoLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFFechaUEcografia, -2, 128, -2).addGap(0, 0, 0).addComponent(this.txtUltimaEco, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnEnfMama).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDRMamas)).addGroup(jpGinecologicoLayout.createSequentialGroup().addComponent(this.JTFFechaUCitologia, -2, 128, -2).addGap(0, 0, 0).addComponent(this.cboUltimaCitologia, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHRealizado)).addGroup(jpGinecologicoLayout.createSequentialGroup().addComponent(this.txtTiempoPlanifica, -2, 179, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboMetodo, -2, 440, -2))).addGap(0, 32, 32767)))));
        jpGinecologicoLayout.setVerticalGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jpGinecologicoLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtMenarquia, -2, 50, -2).addComponent(this.txtUltimaEco, -2, 50, -2).addComponent(this.JTFFechaUEcografia, -2, 50, -2).addComponent(this.btnEnfMama, -2, 50, -2).addComponent(this.JSPDRMamas, -2, 77, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboMetodo, -2, 50, -2).addGroup(jpGinecologicoLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTiempoPlanifica, -2, 50, -2).addComponent(this.txtEdadRelaciones, -2, 50, -2)))).addGap(5, 5, 5).addGroup(jpGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboUltimaCitologia, -2, 50, -2).addComponent(this.JTFFechaUCitologia, -2, 50, -2).addComponent(this.JCHRealizado, -2, 50, -2).addComponent(this.JTFCiclo, GroupLayout.Alignment.TRAILING, -2, 50, -2))));
        this.jbtnGuardar.setFont(new Font("Arial", 1, 12));
        this.jbtnGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_Guardar_Antecedentes.png")));
        this.jbtnGuardar.setText("Grabar");
        this.jbtnGuardar.setHorizontalTextPosition(0);
        this.jbtnGuardar.setRolloverIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_Guardar_Antecedentes_1.png")));
        this.jbtnGuardar.setVerticalTextPosition(3);
        this.jbtnGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.13
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesGinecobstetricos.this.jbtnGuardarActionPerformed(evt);
            }
        });
        this.jpQuirurgico.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Fechas de Realización de Procedimientos Quirúrgicos", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.txtCauterizacion.setDateFormatString("dd/MM/yyyy");
        this.txtCauterizacion.setFont(new Font("Tahoma", 1, 12));
        this.txtCauterizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtCauterizacion.setName("cboMenarquia");
        this.txtCauterizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtCauterizacionPropertyChange(evt);
            }
        });
        this.txtRadioterapia.setDateFormatString("dd/MM/yyyy");
        this.txtRadioterapia.setFont(new Font("Tahoma", 1, 12));
        this.txtRadioterapia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtRadioterapia.setName("cboMenarquia");
        this.txtRadioterapia.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtRadioterapiaPropertyChange(evt);
            }
        });
        this.txtHisterectomia.setDateFormatString("dd/MM/yyyy");
        this.txtHisterectomia.setFont(new Font("Tahoma", 1, 12));
        this.txtHisterectomia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtHisterectomia.setName("cboMenarquia");
        this.txtHisterectomia.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtHisterectomiaPropertyChange(evt);
            }
        });
        this.txtConizacion.setDateFormatString("dd/MM/yyyy");
        this.txtConizacion.setFont(new Font("Tahoma", 1, 12));
        this.txtConizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtConizacion.setName("cboMenarquia");
        this.txtConizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtConizacionPropertyChange(evt);
            }
        });
        this.txtBiopsia.setDateFormatString("dd/MM/yyyy");
        this.txtBiopsia.setFont(new Font("Tahoma", 1, 12));
        this.txtBiopsia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtBiopsia.setName("cboMenarquia");
        this.txtBiopsia.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.18
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedentesGinecobstetricos.this.txtBiopsiaPropertyChange(evt);
            }
        });
        this.JTFFechaUCuelloU.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUCuelloU.setHorizontalAlignment(4);
        this.JTFFechaUCuelloU.setBorder(BorderFactory.createTitledBorder((Border) null, "Cauterización CU", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaURadioTerapia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaURadioTerapia.setHorizontalAlignment(4);
        this.JTFFechaURadioTerapia.setBorder(BorderFactory.createTitledBorder((Border) null, "Radioterapia Utero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUHisterectomia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUHisterectomia.setHorizontalAlignment(4);
        this.JTFFechaUHisterectomia.setBorder(BorderFactory.createTitledBorder((Border) null, "Histerectomia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUConizacionCU.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUConizacionCU.setHorizontalAlignment(4);
        this.JTFFechaUConizacionCU.setBorder(BorderFactory.createTitledBorder((Border) null, "Conización CU", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUBiopsia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUBiopsia.setHorizontalAlignment(4);
        this.JTFFechaUBiopsia.setBorder(BorderFactory.createTitledBorder((Border) null, "Última Biopsia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jpQuirurgicoLayout = new GroupLayout(this.jpQuirurgico);
        this.jpQuirurgico.setLayout(jpQuirurgicoLayout);
        jpQuirurgicoLayout.setHorizontalGroup(jpQuirurgicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jpQuirurgicoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFechaUCuelloU, -2, 130, -2).addGap(0, 0, 0).addComponent(this.txtCauterizacion, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFechaURadioTerapia, -2, 130, -2).addGap(0, 0, 0).addComponent(this.txtRadioterapia, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFechaUHisterectomia, -2, 130, -2).addGap(0, 0, 0).addComponent(this.txtHisterectomia, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaUConizacionCU, -2, 130, -2).addGap(0, 0, 0).addComponent(this.txtConizacion, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFechaUBiopsia, -2, 130, -2).addGap(0, 0, 0).addComponent(this.txtBiopsia, -2, 20, -2).addContainerGap(-1, 32767)));
        jpQuirurgicoLayout.setVerticalGroup(jpQuirurgicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jpQuirurgicoLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(jpQuirurgicoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFechaUBiopsia, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.txtConizacion, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JTFFechaUConizacionCU, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.txtCauterizacion, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JTFFechaUCuelloU, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.txtHisterectomia, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JTFFechaUHisterectomia, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.txtRadioterapia, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JTFFechaURadioTerapia, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.txtBiopsia, GroupLayout.Alignment.LEADING, -2, 50, -2))));
        this.jbtnNuevo.setFont(new Font("Arial", 1, 12));
        this.jbtnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_LimpiarCampos_48_1.png")));
        this.jbtnNuevo.setText("Limpiar campos");
        this.jbtnNuevo.setHorizontalTextPosition(0);
        this.jbtnNuevo.setRolloverIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_LimpiarCampos_48.png")));
        this.jbtnNuevo.setVerticalTextPosition(3);
        this.jbtnNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos.19
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesGinecobstetricos.this.jbtnNuevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jpObstetrico, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jpQuirurgico, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jpGinecologico, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jbtnNuevo, -2, 397, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jbtnGuardar, -2, 397, -2))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jpGinecologico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpQuirurgico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpObstetrico, -2, -1, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jbtnNuevo, -2, 73, -2).addComponent(this.jbtnGuardar, -2, 73, -2)).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jbtnGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmbarazadaActionPerformed(ActionEvent evt) {
        if (this.JCHEmbarazada.isSelected()) {
            this.JTFSemanaG.setText("" + this.metodos.mSemanaGestacion(this.JTFFechaUMestruacion.getText()));
            this.JTFFechaPParto.setText("" + getFPP(this.JTFFechaUMestruacion.getText()));
        } else {
            this.JTFSemanaG.setText("0");
            this.JTFFechaPParto.setText("");
        }
    }

    private Date getFPP(String xFUM) {
        Date xValor = null;
        String sql = "SELECT DATE_SUB(ADDDATE(DATE_ADD(('" + xFUM + "'),INTERVAL 1 YEAR),7),INTERVAL 3 MONTH) AS FPP";
        ConsultasMySQL xctr = new ConsultasMySQL();
        ResultSet xrs = xctr.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xValor = xrs.getDate("FPP");
            }
            xrs.close();
            xctr.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmbarazada1ActionPerformed(ActionEvent evt) {
        if (this.JCHEmbarazada1.isSelected()) {
            this.xGemelar = 1;
        } else {
            this.xGemelar = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimaEcoPropertyChange(PropertyChangeEvent evt) {
        if (this.txtUltimaEco.getDate() != null) {
            this.JTFFechaUEcografia.setText(this.metodos.formatoDMA.format(this.txtUltimaEco.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEnfMamaActionPerformed(ActionEvent evt) {
        if (this.btnEnfMama.isSelected()) {
            this.enfMama = 1;
        } else {
            this.enfMama = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtResultadoMamasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.txtResultadoMamas.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaCitologiaPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaCitologia.getDate() != null) {
            this.JTFFechaUCitologia.setText(this.metodos.formatoDMA.format(this.cboUltimaCitologia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRealizadoActionPerformed(ActionEvent evt) {
        if (this.JCHRealizado.isSelected()) {
            this.JTFFechaUCitologia.setText("SIN REALIZAR");
            this.cboUltimaCitologia.setEnabled(false);
            this.JTFFechaUCitologia.setEditable(false);
        } else {
            this.JTFFechaUCitologia.setText("");
            this.cboUltimaCitologia.setEnabled(true);
            this.JTFFechaUCitologia.setEditable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCauterizacionPropertyChange(PropertyChangeEvent evt) {
        if (this.txtCauterizacion.getDate() != null) {
            this.JTFFechaUCuelloU.setText(this.metodos.formatoDMA.format(this.txtCauterizacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtRadioterapiaPropertyChange(PropertyChangeEvent evt) {
        if (this.txtRadioterapia.getDate() != null) {
            this.JTFFechaURadioTerapia.setText(this.metodos.formatoDMA.format(this.txtRadioterapia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHisterectomiaPropertyChange(PropertyChangeEvent evt) {
        if (this.txtHisterectomia.getDate() != null) {
            this.JTFFechaUHisterectomia.setText(this.metodos.formatoDMA.format(this.txtHisterectomia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtConizacionPropertyChange(PropertyChangeEvent evt) {
        if (this.txtConizacion.getDate() != null) {
            this.JTFFechaUConizacionCU.setText(this.metodos.formatoDMA.format(this.txtConizacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtBiopsiaPropertyChange(PropertyChangeEvent evt) {
        if (this.txtBiopsia.getDate() != null) {
            this.JTFFechaUBiopsia.setText(this.metodos.formatoDMA.format(this.txtBiopsia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimoPartoPropertyChange(PropertyChangeEvent evt) {
        if (this.txtUltimoParto.getDate() != null) {
            this.JTFFechaUParto.setText(this.metodos.formatoDMA.format(this.txtUltimoParto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaAbortoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaAborto.getDate() != null) {
            this.JTFFechaUAborto.setText(this.metodos.formatoDMA.format(this.cboUltimaAborto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaMestruacionPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaMestruacion.getDate() != null) {
            this.JTFFechaUMestruacion.setText(this.metodos.formatoAMD.format(this.cboUltimaMestruacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaLegradoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaLegrado.getDate() != null) {
            this.JTFFechaULegrado.setText(this.metodos.formatoDMA.format(this.cboUltimaLegrado.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaPPartoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboFechaPParto.getDate() != null) {
            this.JTFFechaPParto.setText(this.metodos.formatoDMA.format(this.cboFechaPParto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jbtnNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    public void mGrabar() {
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea grabar ?", "Grabar Antecedentes GinecoObstétricos @GenomaPlus", 1, 3, new ImageIcon("src/Imagenes/Question2.png")) == 0) {
            AntecedentesGinecobstetricosDAO antecedentesGinecobstetricosDAO = this.xAntecedentesGinecobstetricosDAO;
            clasesHistoriaCE claseshistoriace = this.xClaseHC;
            if (!antecedentesGinecobstetricosDAO.validarAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString()).intValue(), Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue())) {
                this.xAntecedentesGinecobstetricosDTO.setIdUsuario(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setIdAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setIdCitologia(getXidcitologia());
                this.xAntecedentesGinecobstetricosDTO.setFum(this.JTFFechaUMestruacion.getText());
                this.xAntecedentesGinecobstetricosDTO.setFuC(this.JTFFechaUCitologia.getText());
                this.xAntecedentesGinecobstetricosDTO.setFueM(this.JTFFechaUEcografia.getText());
                this.xAntecedentesGinecobstetricosDTO.setEnfMama(this.enfMama);
                this.xAntecedentesGinecobstetricosDTO.setDescMama(this.txtResultadoMamas.getText());
                this.xAntecedentesGinecobstetricosDTO.setIdMetPlanifica(Integer.valueOf(this.xIdMetPlanificar[this.cboMetodo.getSelectedIndex()]).intValue());
                this.xAntecedentesGinecobstetricosDTO.setTiempoEnPlanifica(((Integer) this.txtTiempoPlanifica.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoG(((Integer) this.txtNoEmbarazos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoP(((Integer) this.txtNoPartos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoC(((Integer) this.txtNoCesareas.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoA(((Integer) this.txtNoAbortos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setUltimoParto(this.JTFFechaUParto.getText());
                this.xAntecedentesGinecobstetricosDTO.setUltimoAborto(this.JTFFechaUAborto.getText());
                this.xAntecedentesGinecobstetricosDTO.setNoE(((Integer) this.txtNoEptopicos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoM(((Integer) this.txtNoMuertos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoV(((Integer) this.txtNoVivos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setMenarquia(this.txtMenarquia.getText());
                this.xAntecedentesGinecobstetricosDTO.setEdadInicioRel(((Integer) this.txtEdadRelaciones.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setCauterizacionCuello(this.JTFFechaUCuelloU.getText());
                this.xAntecedentesGinecobstetricosDTO.setRadioterapiaUtero(this.JTFFechaURadioTerapia.getText());
                this.xAntecedentesGinecobstetricosDTO.setHisterectomia(this.JTFFechaUHisterectomia.getText());
                this.xAntecedentesGinecobstetricosDTO.setConizacionCuello(this.JTFFechaUConizacionCU.getText());
                this.xAntecedentesGinecobstetricosDTO.setCiclos(this.JTFCiclo.getText());
                this.xAntecedentesGinecobstetricosDTO.setBiopsia(this.JTFFechaUBiopsia.getText());
                this.xAntecedentesGinecobstetricosDTO.setFpParto(this.JTFFechaPParto.getText());
                this.xAntecedentesGinecobstetricosDTO.setSemanaG(this.JTFSemanaG.getText());
                this.xAntecedentesGinecobstetricosDTO.setLegrado(this.JTFFechaULegrado.getText());
                this.xAntecedentesGinecobstetricosDTO.setGemelar(this.xGemelar);
                this.xAntecedentesGinecobstetricosDTO.setFecha(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                this.xAntecedentesGinecobstetricosDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.xAntecedentesGinecobstetricosDAO.mCreate(this.xAntecedentesGinecobstetricosDTO);
            } else {
                this.xAntecedentesGinecobstetricosDTO.setFum(this.JTFFechaUMestruacion.getText());
                this.xAntecedentesGinecobstetricosDTO.setFuC(this.JTFFechaUCitologia.getText());
                this.xAntecedentesGinecobstetricosDTO.setFueM(this.JTFFechaUEcografia.getText());
                this.xAntecedentesGinecobstetricosDTO.setEnfMama(this.enfMama);
                this.xAntecedentesGinecobstetricosDTO.setDescMama(this.txtResultadoMamas.getText());
                this.xAntecedentesGinecobstetricosDTO.setIdMetPlanifica(Integer.valueOf(this.xIdMetPlanificar[this.cboMetodo.getSelectedIndex()]).intValue());
                this.xAntecedentesGinecobstetricosDTO.setTiempoEnPlanifica(((Integer) this.txtTiempoPlanifica.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoG(((Integer) this.txtNoEmbarazos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoP(((Integer) this.txtNoPartos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoC(((Integer) this.txtNoCesareas.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoA(((Integer) this.txtNoAbortos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setUltimoParto(this.JTFFechaUParto.getText());
                this.xAntecedentesGinecobstetricosDTO.setUltimoAborto(this.JTFFechaUAborto.getText());
                this.xAntecedentesGinecobstetricosDTO.setNoE(((Integer) this.txtNoEptopicos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoM(((Integer) this.txtNoMuertos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setNoV(((Integer) this.txtNoVivos.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setMenarquia(this.txtMenarquia.getText());
                this.xAntecedentesGinecobstetricosDTO.setEdadInicioRel(((Integer) this.txtEdadRelaciones.getValue()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setCauterizacionCuello(this.JTFFechaUCuelloU.getText());
                this.xAntecedentesGinecobstetricosDTO.setRadioterapiaUtero(this.JTFFechaURadioTerapia.getText());
                this.xAntecedentesGinecobstetricosDTO.setHisterectomia(this.JTFFechaUHisterectomia.getText());
                this.xAntecedentesGinecobstetricosDTO.setConizacionCuello(this.JTFFechaUConizacionCU.getText());
                this.xAntecedentesGinecobstetricosDTO.setCiclos(this.JTFCiclo.getText());
                this.xAntecedentesGinecobstetricosDTO.setBiopsia(this.JTFFechaUBiopsia.getText());
                this.xAntecedentesGinecobstetricosDTO.setFpParto(this.JTFFechaPParto.getText());
                this.xAntecedentesGinecobstetricosDTO.setSemanaG(this.JTFSemanaG.getText());
                this.xAntecedentesGinecobstetricosDTO.setLegrado(this.JTFFechaULegrado.getText());
                this.xAntecedentesGinecobstetricosDTO.setGemelar(this.xGemelar);
                this.xAntecedentesGinecobstetricosDTO.setFecha(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                this.xAntecedentesGinecobstetricosDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.xAntecedentesGinecobstetricosDTO.setIdUsuario(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString()).intValue());
                this.xAntecedentesGinecobstetricosDTO.setIdAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xAntecedentesGinecobstetricosDAO.mUpdate(this.xAntecedentesGinecobstetricosDTO);
                JOptionPane.showMessageDialog((Component) null, "Ya existe un antecedente con esta atención. La información se actualizó", "Actualizar Información", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    public void mCargarComboMetPlanificar() {
        this.cboMetodo.removeAllItems();
        List<GCGenericoDTO> listMetPla = this.xAntecedentesGinecobstetricosDAO.listMetodosPlanificar();
        this.xIdMetPlanificar = new String[listMetPla.size()];
        for (int x = 0; x < listMetPla.size(); x++) {
            this.xIdMetPlanificar[x] = String.valueOf(listMetPla.get(x).getId());
            this.cboMetodo.addItem(listMetPla.get(x).getNombre());
        }
        this.cboMetodo.setSelectedIndex(-1);
    }

    public int getXidcitologia() {
        return this.xidcitologia;
    }

    public void setXidcitologia(int xidcitologia) {
        this.xidcitologia = xidcitologia;
    }

    private void mCargarDatos() {
        AntecedentesGinecobstetricosDAO antecedentesGinecobstetricosDAO = this.xAntecedentesGinecobstetricosDAO;
        clasesHistoriaCE claseshistoriace = this.xClaseHC;
        List<AntecedentesGinecobstetricosDTO> list = antecedentesGinecobstetricosDAO.listAnteGinecoobstetrico(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString()).intValue());
        if (!list.isEmpty()) {
            this.JTFFechaUMestruacion.setText(list.get(0).getFum());
            this.JTFFechaUCitologia.setText(list.get(0).getFuC());
            this.JTFFechaUEcografia.setText(list.get(0).getFueM());
            if (list.get(0).getEnfMama() == 1) {
                this.enfMama = 1;
                this.btnEnfMama.setSelected(true);
            }
            this.txtResultadoMamas.setText(list.get(0).getDescMama());
            this.cboMetodo.setSelectedItem(Integer.valueOf(list.get(0).getIdMetPlanifica()));
            this.txtTiempoPlanifica.setValue(Integer.valueOf(list.get(0).getTiempoEnPlanifica()));
            this.txtNoEmbarazos.setValue(Integer.valueOf(list.get(0).getNoG()));
            this.txtNoPartos.setValue(Integer.valueOf(list.get(0).getNoP()));
            this.txtNoCesareas.setValue(Integer.valueOf(list.get(0).getNoC()));
            this.txtNoAbortos.setValue(Integer.valueOf(list.get(0).getNoA()));
            this.JTFFechaUParto.setText(list.get(0).getUltimoParto());
            this.JTFFechaUAborto.setText(list.get(0).getUltimoAborto());
            this.txtNoEptopicos.setValue(Integer.valueOf(list.get(0).getNoE()));
            this.txtNoMuertos.setValue(Integer.valueOf(list.get(0).getNoM()));
            this.txtNoVivos.setValue(Integer.valueOf(list.get(0).getNoV()));
            this.txtMenarquia.setText(list.get(0).getMenarquia());
            this.txtEdadRelaciones.setValue(Integer.valueOf(list.get(0).getEdadInicioRel()));
            this.JTFFechaUCuelloU.setText(list.get(0).getCauterizacionCuello());
            this.JTFFechaURadioTerapia.setText(list.get(0).getRadioterapiaUtero());
            this.JTFFechaUHisterectomia.setText(list.get(0).getHisterectomia());
            this.JTFFechaUConizacionCU.setText(list.get(0).getConizacionCuello());
            this.JTFCiclo.setText(list.get(0).getCiclos());
            this.JTFFechaUBiopsia.setText(list.get(0).getBiopsia());
            this.JTFFechaPParto.setText(list.get(0).getFpParto());
            this.JTFSemanaG.setText(list.get(0).getSemanaG());
            this.JTFFechaULegrado.setText(list.get(0).getLegrado());
            if (list.get(0).getGemelar() == 1) {
                this.xGemelar = 1;
                this.JCHEmbarazada1.setSelected(true);
            }
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }
}
