package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAEvaluacionRiesgo.class */
public class JPAEvaluacionRiesgo extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String sql;
    private int xSifilisG;
    private int xHipertensionInd;
    private int xHipotiroidismoCong;

    /* JADX INFO: renamed from: xSintomáticoResp, reason: contains not printable characters */
    private int f5xSintomticoResp;
    private int xLepra;
    private int xObesidadProteica;
    private int xVictimaltrato;

    /* JADX INFO: renamed from: xVíctViolenciaSex, reason: contains not printable characters */
    private int f6xVctViolenciaSex;
    private int xEnfMetal;
    private int xCancerCervix;
    private int xCancerSenoPG;
    private int xTuberculosis;
    private int xTransmisionsex;
    private JComboBox JCBCancerCervix;
    private JComboBox JCBCancerSenoPG;
    private JComboBox JCBEnfMetal;
    private JComboBox JCBHipertensionInd;
    private JComboBox JCBHipotiroidismoCong;
    private JComboBox JCBLepra;
    private JComboBox JCBObesidadProteica;
    private JComboBox JCBSifilisG;

    /* JADX INFO: renamed from: JCBSintomáticoResp, reason: contains not printable characters */
    private JComboBox f7JCBSintomticoResp;
    private JComboBox JCBTransmisionSex;
    private JComboBox JCBTuberculosis;

    /* JADX INFO: renamed from: JCBVíctViolenciaSex, reason: contains not printable characters */
    private JComboBox f8JCBVctViolenciaSex;

    /* JADX INFO: renamed from: JCBVíctimaltrato, reason: contains not printable characters */
    private JComboBox f9JCBVctimaltrato;
    private JTable JTDetalle;
    private JTabbedPane JTPGeneral;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JPAEvaluacionRiesgo() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v147, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPGeneral = new JTabbedPane();
        this.jPanel5 = new JPanel();
        this.jPanel1 = new JPanel();
        this.f7JCBSintomticoResp = new JComboBox();
        this.JCBHipotiroidismoCong = new JComboBox();
        this.JCBHipertensionInd = new JComboBox();
        this.JCBSifilisG = new JComboBox();
        this.JCBTuberculosis = new JComboBox();
        this.jPanel2 = new JPanel();
        this.f8JCBVctViolenciaSex = new JComboBox();
        this.JCBLepra = new JComboBox();
        this.JCBObesidadProteica = new JComboBox();
        this.f9JCBVctimaltrato = new JComboBox();
        this.JCBTransmisionSex = new JComboBox();
        this.jPanel3 = new JPanel();
        this.JCBCancerSenoPG = new JComboBox();
        this.JCBCancerCervix = new JComboBox();
        this.JCBEnfMetal = new JComboBox();
        this.jPanel4 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setName("xevaluacionriesgo");
        this.JTPGeneral.setForeground(Color.red);
        this.JTPGeneral.setFont(new Font("Arial", 1, 12));
        this.jPanel5.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.f7JCBSintomticoResp.setFont(new Font("Arial", 1, 12));
        this.f7JCBSintomticoResp.setModel(new DefaultComboBoxModel(new String[]{"Si", "No", "Riesgo no evaluado"}));
        this.f7JCBSintomticoResp.setSelectedIndex(1);
        this.f7JCBSintomticoResp.setBorder(BorderFactory.createTitledBorder((Border) null, "Sintomático Respiratorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f7JCBSintomticoResp.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.1
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.m21JCBSintomticoRespItemStateChanged(evt);
            }
        });
        this.f7JCBSintomticoResp.addActionListener(new ActionListener() { // from class: Historia.JPAEvaluacionRiesgo.2
            public void actionPerformed(ActionEvent evt) {
                JPAEvaluacionRiesgo.this.m24JCBSintomticoRespActionPerformed(evt);
            }
        });
        this.JCBHipotiroidismoCong.setFont(new Font("Arial", 1, 12));
        this.JCBHipotiroidismoCong.setModel(new DefaultComboBoxModel(new String[]{"No aplica", "Si", "No", "Riesgo no evaluado"}));
        this.JCBHipotiroidismoCong.setBorder(BorderFactory.createTitledBorder((Border) null, "Hipotiroidismo Congénito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHipotiroidismoCong.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.3
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBHipotiroidismoCongItemStateChanged(evt);
            }
        });
        this.JCBHipertensionInd.setFont(new Font("Arial", 1, 12));
        this.JCBHipertensionInd.setModel(new DefaultComboBoxModel(new String[]{"No aplica", "Si", "No", "Riesgo no evaluado"}));
        this.JCBHipertensionInd.setBorder(BorderFactory.createTitledBorder((Border) null, "Hipertensión Inducida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHipertensionInd.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.4
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBHipertensionIndItemStateChanged(evt);
            }
        });
        this.JCBSifilisG.setFont(new Font("Arial", 1, 12));
        this.JCBSifilisG.setModel(new DefaultComboBoxModel(new String[]{"No aplica", "Si es mujer con sífilis gestacional", "Si es recién nacido con sífilis congénita", "No", "Riesgo no evaluado"}));
        this.JCBSifilisG.setBorder(BorderFactory.createTitledBorder((Border) null, "Sífilis Gestacional o congénita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSifilisG.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.5
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBSifilisGItemStateChanged(evt);
            }
        });
        this.JCBTuberculosis.setFont(new Font("Arial", 1, 12));
        this.JCBTuberculosis.setModel(new DefaultComboBoxModel(new String[]{"No aplica", "Si", "No", "Riesgo no evaluado"}));
        this.JCBTuberculosis.setToolTipText("Tuberculosis Multidrogoresistente");
        this.JCBTuberculosis.setBorder(BorderFactory.createTitledBorder((Border) null, "Tuberculosis Multidrogoresistente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTuberculosis.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.6
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBTuberculosisItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBHipotiroidismoCong, 0, -1, 32767).addComponent(this.f7JCBSintomticoResp, 0, -1, 32767).addComponent(this.JCBSifilisG, -2, 203, -2).addComponent(this.JCBHipertensionInd, 0, -1, 32767).addComponent(this.JCBTuberculosis, 0, -1, 32767)).addContainerGap(14, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBSifilisG, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBHipertensionInd, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBHipotiroidismoCong, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.f7JCBSintomticoResp, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTuberculosis, -2, 48, -2).addGap(33, 33, 33)));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.f8JCBVctViolenciaSex.setFont(new Font("Arial", 1, 12));
        this.f8JCBVctViolenciaSex.setModel(new DefaultComboBoxModel(new String[]{"Si", "No", "Riesgo no evaluado"}));
        this.f8JCBVctViolenciaSex.setSelectedIndex(1);
        this.f8JCBVctViolenciaSex.setBorder(BorderFactory.createTitledBorder((Border) null, "Víctima de Violencia Sexual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f8JCBVctViolenciaSex.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.7
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.m23JCBVctViolenciaSexItemStateChanged(evt);
            }
        });
        this.JCBLepra.setFont(new Font("Arial", 1, 12));
        this.JCBLepra.setModel(new DefaultComboBoxModel(new String[]{"Paucibacilar", "Multibacilar", "No", "Riesgo no evaluado"}));
        this.JCBLepra.setSelectedIndex(2);
        this.JCBLepra.setBorder(BorderFactory.createTitledBorder((Border) null, "Lepra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLepra.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.8
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBLepraItemStateChanged(evt);
            }
        });
        this.JCBObesidadProteica.setFont(new Font("Arial", 1, 12));
        this.JCBObesidadProteica.setModel(new DefaultComboBoxModel(new String[]{"Si es Obesidad", "Si es Desnutrición Proteico Calórica", "No", "Riesgo no evaluado"}));
        this.JCBObesidadProteica.setSelectedIndex(2);
        this.JCBObesidadProteica.setToolTipText("Obesidad o Desnutrición Proteico Calórica");
        this.JCBObesidadProteica.setBorder(BorderFactory.createTitledBorder((Border) null, "Obesidad o Desnutrición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBObesidadProteica.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.9
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBObesidadProteicaItemStateChanged(evt);
            }
        });
        this.f9JCBVctimaltrato.setFont(new Font("Arial", 1, 12));
        this.f9JCBVctimaltrato.setModel(new DefaultComboBoxModel(new String[]{"No aplica", "Si es Mujer víctima del maltrato", "Si es Menor víctima del maltrato", "No", "Riesgo no evaluado"}));
        this.f9JCBVctimaltrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Víctima de Maltrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f9JCBVctimaltrato.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.10
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.m22JCBVctimaltratoItemStateChanged(evt);
            }
        });
        this.JCBTransmisionSex.setFont(new Font("Arial", 1, 12));
        this.JCBTransmisionSex.setModel(new DefaultComboBoxModel(new String[]{"Si", "No", "Riesgo no evaluado"}));
        this.JCBTransmisionSex.setSelectedIndex(1);
        this.JCBTransmisionSex.setToolTipText("Infecciones de Trasmisión Sexual");
        this.JCBTransmisionSex.setBorder(BorderFactory.createTitledBorder((Border) null, "Infecciones de Trasmisión Sexual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTransmisionSex.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.11
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBTransmisionSexItemStateChanged(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.f8JCBVctViolenciaSex, -2, 203, -2).addComponent(this.JCBLepra, -2, 203, -2).addComponent(this.f9JCBVctimaltrato, -2, 203, -2).addComponent(this.JCBTransmisionSex, -2, 203, -2).addComponent(this.JCBObesidadProteica, -2, 203, -2)).addContainerGap(20, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBLepra, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBObesidadProteica, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.f9JCBVctimaltrato, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.f8JCBVctViolenciaSex, -2, 48, -2).addGap(11, 11, 11).addComponent(this.JCBTransmisionSex, -2, 48, -2).addContainerGap()));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.JCBCancerSenoPG.setFont(new Font("Arial", 1, 12));
        this.JCBCancerSenoPG.setModel(new DefaultComboBoxModel(new String[]{"Si", "No", "Riesgo no evaluado"}));
        this.JCBCancerSenoPG.setSelectedIndex(1);
        this.JCBCancerSenoPG.setBorder(BorderFactory.createTitledBorder((Border) null, "Cáncer de Seno (general)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCancerSenoPG.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.12
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBCancerSenoPGItemStateChanged(evt);
            }
        });
        this.JCBCancerCervix.setFont(new Font("Arial", 1, 12));
        this.JCBCancerCervix.setModel(new DefaultComboBoxModel(new String[]{"No aplica", "Si", "No", "Riesgo no evaluado"}));
        this.JCBCancerCervix.setBorder(BorderFactory.createTitledBorder((Border) null, "Cáncer de Cérvix", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCancerCervix.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.13
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBCancerCervixItemStateChanged(evt);
            }
        });
        this.JCBEnfMetal.setFont(new Font("Arial", 1, 12));
        this.JCBEnfMetal.setModel(new DefaultComboBoxModel(new String[]{"Si el diagnóstico es Ansiedad", "Si el diagnóstico es Depresión", "Si el diagnóstico es esquizofrenia", "Si el diagnóstico es Déficit de atención por Hiperactividad", "Si el diagnóstico es consumo Sustancias Psicoactivas", "Si el diagnóstico es Trastorno del Ánimo Bipolar", "No", "Riesgo no evaluado"}));
        this.JCBEnfMetal.setSelectedIndex(6);
        this.JCBEnfMetal.setBorder(BorderFactory.createTitledBorder((Border) null, "Enfermedad Metal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEnfMetal.addItemListener(new ItemListener() { // from class: Historia.JPAEvaluacionRiesgo.14
            public void itemStateChanged(ItemEvent evt) {
                JPAEvaluacionRiesgo.this.JCBEnfMetalItemStateChanged(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCBCancerSenoPG, -2, 203, -2)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBCancerCervix, -2, 203, -2)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEnfMetal, -2, 203, -2))).addContainerGap(14, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEnfMetal, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCancerCervix, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCancerSenoPG, -2, 48, -2).addContainerGap(-1, 32767)));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 751, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addContainerGap(-1, 32767))));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 365, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel1, -2, 0, 32767).addComponent(this.jPanel2, -2, -1, -2)).addContainerGap(-1, 32767))));
        this.JTPGeneral.addTab("DATOS", this.jPanel5);
        this.jPanel4.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPAEvaluacionRiesgo.15
            public void mouseClicked(MouseEvent evt) {
                JPAEvaluacionRiesgo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 751, 32767));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 365, 32767));
        this.JTPGeneral.addTab("HISTÓRICO", this.jPanel4);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSifilisGItemStateChanged(ItemEvent evt) {
        switch (this.JCBSifilisG.getSelectedIndex()) {
            case 0:
                this.xSifilisG = 0;
                break;
            case 1:
                this.xSifilisG = 1;
                break;
            case 2:
                this.xSifilisG = 2;
                break;
            case 3:
                this.xSifilisG = 3;
                break;
            case 4:
                this.xSifilisG = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHipertensionIndItemStateChanged(ItemEvent evt) {
        switch (this.JCBHipertensionInd.getSelectedIndex()) {
            case 0:
                this.xHipertensionInd = 0;
                break;
            case 1:
                this.xHipertensionInd = 1;
                break;
            case 2:
                this.xHipertensionInd = 2;
                break;
            case 3:
                this.xHipertensionInd = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHipotiroidismoCongItemStateChanged(ItemEvent evt) {
        switch (this.JCBHipotiroidismoCong.getSelectedIndex()) {
            case 0:
                this.xHipotiroidismoCong = 0;
                break;
            case 1:
                this.xHipotiroidismoCong = 1;
                break;
            case 2:
                this.xHipotiroidismoCong = 2;
                break;
            case 3:
                this.xHipotiroidismoCong = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JCBSintomáticoRespItemStateChanged, reason: contains not printable characters */
    public void m21JCBSintomticoRespItemStateChanged(ItemEvent evt) {
        switch (this.f7JCBSintomticoResp.getSelectedIndex()) {
            case 0:
                this.f5xSintomticoResp = 1;
                break;
            case 1:
                this.f5xSintomticoResp = 2;
                break;
            case 2:
                this.f5xSintomticoResp = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBLepraItemStateChanged(ItemEvent evt) {
        switch (this.JCBLepra.getSelectedIndex()) {
            case 0:
                this.xLepra = 1;
                break;
            case 1:
                this.xLepra = 2;
                break;
            case 2:
                this.xLepra = 3;
                break;
            case 3:
                this.xLepra = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBObesidadProteicaItemStateChanged(ItemEvent evt) {
        switch (this.JCBObesidadProteica.getSelectedIndex()) {
            case 0:
                this.xObesidadProteica = 1;
                break;
            case 1:
                this.xObesidadProteica = 2;
                break;
            case 2:
                this.xObesidadProteica = 3;
                break;
            case 3:
                this.xObesidadProteica = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JCBVíctimaltratoItemStateChanged, reason: contains not printable characters */
    public void m22JCBVctimaltratoItemStateChanged(ItemEvent evt) {
        switch (this.f9JCBVctimaltrato.getSelectedIndex()) {
            case 0:
                this.xVictimaltrato = 0;
                break;
            case 1:
                this.xVictimaltrato = 1;
                break;
            case 2:
                this.xVictimaltrato = 2;
                break;
            case 3:
                this.xVictimaltrato = 3;
                break;
            case 4:
                this.xVictimaltrato = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JCBVíctViolenciaSexItemStateChanged, reason: contains not printable characters */
    public void m23JCBVctViolenciaSexItemStateChanged(ItemEvent evt) {
        switch (this.f8JCBVctViolenciaSex.getSelectedIndex()) {
            case 0:
                this.f6xVctViolenciaSex = 1;
                break;
            case 1:
                this.f6xVctViolenciaSex = 2;
                break;
            case 2:
                this.f6xVctViolenciaSex = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEnfMetalItemStateChanged(ItemEvent evt) {
        switch (this.JCBEnfMetal.getSelectedIndex()) {
            case 0:
                this.xEnfMetal = 1;
                break;
            case 1:
                this.xEnfMetal = 2;
                break;
            case 2:
                this.xEnfMetal = 3;
                break;
            case 3:
                this.xEnfMetal = 4;
                break;
            case 4:
                this.xEnfMetal = 5;
                break;
            case 5:
                this.xEnfMetal = 6;
                break;
            case 6:
                this.xEnfMetal = 7;
                break;
            case 7:
                this.xEnfMetal = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCancerCervixItemStateChanged(ItemEvent evt) {
        switch (this.JCBCancerCervix.getSelectedIndex()) {
            case 0:
                this.xCancerCervix = 0;
                break;
            case 1:
                this.xCancerCervix = 1;
                break;
            case 2:
                this.xCancerCervix = 2;
                break;
            case 3:
                this.xCancerCervix = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCancerSenoPGItemStateChanged(ItemEvent evt) {
        switch (this.JCBCancerSenoPG.getSelectedIndex()) {
            case 0:
                this.xCancerSenoPG = 1;
                break;
            case 1:
                this.xCancerSenoPG = 2;
                break;
            case 2:
                this.xCancerSenoPG = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTuberculosisItemStateChanged(ItemEvent evt) {
        switch (this.JCBTuberculosis.getSelectedIndex()) {
            case 0:
                this.xTuberculosis = 0;
                break;
            case 1:
                this.xTuberculosis = 1;
                break;
            case 2:
                this.xTuberculosis = 2;
                break;
            case 3:
                this.xTuberculosis = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JCBSintomáticoRespActionPerformed, reason: contains not printable characters */
    public void m24JCBSintomticoRespActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTransmisionSexItemStateChanged(ItemEvent evt) {
        switch (this.JCBTransmisionSex.getSelectedIndex()) {
            case 0:
                this.xTransmisionsex = 1;
                break;
            case 1:
                this.xTransmisionsex = 2;
                break;
            case 2:
                this.xTransmisionsex = 21;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).intValue()) {
            case 0:
                this.JCBSifilisG.setSelectedIndex(0);
                break;
            case 1:
                this.JCBSifilisG.setSelectedIndex(1);
                break;
            case 2:
                this.JCBSifilisG.setSelectedIndex(2);
                break;
            case 3:
                this.JCBSifilisG.setSelectedIndex(3);
                break;
            case 21:
                this.JCBSifilisG.setSelectedIndex(4);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).intValue()) {
            case 0:
                this.JCBHipertensionInd.setSelectedIndex(0);
                break;
            case 1:
                this.JCBHipertensionInd.setSelectedIndex(1);
                break;
            case 2:
                this.JCBHipertensionInd.setSelectedIndex(2);
                break;
            case 21:
                this.JCBHipertensionInd.setSelectedIndex(3);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).intValue()) {
            case 0:
                this.JCBHipotiroidismoCong.setSelectedIndex(0);
                break;
            case 1:
                this.JCBHipotiroidismoCong.setSelectedIndex(1);
                break;
            case 2:
                this.JCBHipotiroidismoCong.setSelectedIndex(2);
                break;
            case 21:
                this.JCBHipotiroidismoCong.setSelectedIndex(3);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).intValue()) {
            case 1:
                this.f7JCBSintomticoResp.setSelectedIndex(0);
                break;
            case 2:
                this.f7JCBSintomticoResp.setSelectedIndex(1);
                break;
            case 21:
                this.f7JCBSintomticoResp.setSelectedIndex(2);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).intValue()) {
            case 0:
                this.JCBTuberculosis.setSelectedIndex(0);
                break;
            case 1:
                this.JCBTuberculosis.setSelectedIndex(1);
                break;
            case 2:
                this.JCBTuberculosis.setSelectedIndex(2);
                break;
            case 21:
                this.JCBTuberculosis.setSelectedIndex(3);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).intValue()) {
            case 1:
                this.JCBLepra.setSelectedIndex(0);
                break;
            case 2:
                this.JCBLepra.setSelectedIndex(1);
                break;
            case 3:
                this.JCBLepra.setSelectedIndex(2);
                break;
            case 21:
                this.JCBLepra.setSelectedIndex(3);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()).intValue()) {
            case 1:
                this.JCBObesidadProteica.setSelectedIndex(0);
                break;
            case 2:
                this.JCBObesidadProteica.setSelectedIndex(1);
                break;
            case 3:
                this.JCBObesidadProteica.setSelectedIndex(2);
                break;
            case 21:
                this.JCBObesidadProteica.setSelectedIndex(3);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString()).intValue()) {
            case 0:
                this.f9JCBVctimaltrato.setSelectedIndex(0);
                break;
            case 1:
                this.f9JCBVctimaltrato.setSelectedIndex(1);
                break;
            case 2:
                this.f9JCBVctimaltrato.setSelectedIndex(2);
                break;
            case 3:
                this.f9JCBVctimaltrato.setSelectedIndex(3);
                break;
            case 21:
                this.f9JCBVctimaltrato.setSelectedIndex(4);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()).intValue()) {
            case 1:
                this.f8JCBVctViolenciaSex.setSelectedIndex(0);
                break;
            case 2:
                this.f8JCBVctViolenciaSex.setSelectedIndex(1);
                break;
            case 21:
                this.f8JCBVctViolenciaSex.setSelectedIndex(2);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()).intValue()) {
            case 1:
                this.JCBTransmisionSex.setSelectedIndex(0);
                break;
            case 2:
                this.JCBTransmisionSex.setSelectedIndex(1);
                break;
            case 21:
                this.JCBTransmisionSex.setSelectedIndex(2);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).intValue()) {
            case 1:
                this.JCBEnfMetal.setSelectedIndex(0);
                break;
            case 2:
                this.JCBEnfMetal.setSelectedIndex(1);
                break;
            case 3:
                this.JCBEnfMetal.setSelectedIndex(2);
                break;
            case 4:
                this.JCBEnfMetal.setSelectedIndex(3);
                break;
            case 5:
                this.JCBEnfMetal.setSelectedIndex(4);
                break;
            case 6:
                this.JCBEnfMetal.setSelectedIndex(5);
                break;
            case 7:
                this.JCBEnfMetal.setSelectedIndex(6);
                break;
            case 21:
                this.JCBEnfMetal.setSelectedIndex(7);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()).intValue()) {
            case 0:
                this.JCBCancerCervix.setSelectedIndex(0);
                break;
            case 1:
                this.JCBCancerCervix.setSelectedIndex(1);
                break;
            case 2:
                this.JCBCancerCervix.setSelectedIndex(2);
                break;
            case 21:
                this.JCBCancerCervix.setSelectedIndex(3);
                break;
        }
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()).intValue()) {
            case 1:
                this.JCBCancerSenoPG.setSelectedIndex(0);
                break;
            case 2:
                this.JCBCancerSenoPG.setSelectedIndex(1);
                break;
            case 21:
                this.JCBCancerSenoPG.setSelectedIndex(2);
                break;
        }
        this.JTPGeneral.setSelectedIndex(0);
    }

    public void mNuevo() {
        this.JCBSifilisG.setSelectedIndex(3);
        this.JCBHipertensionInd.setSelectedIndex(2);
        this.JCBHipotiroidismoCong.setSelectedIndex(2);
        this.f7JCBSintomticoResp.setSelectedIndex(1);
        this.JCBTuberculosis.setSelectedIndex(2);
        this.JCBLepra.setSelectedIndex(2);
        this.JCBObesidadProteica.setSelectedIndex(2);
        this.f9JCBVctimaltrato.setSelectedIndex(3);
        this.f8JCBVctViolenciaSex.setSelectedIndex(1);
        this.JCBTransmisionSex.setSelectedIndex(1);
        this.JCBEnfMetal.setSelectedIndex(6);
        this.JCBCancerCervix.setSelectedIndex(2);
        this.JCBCancerSenoPG.setSelectedIndex(1);
        JCBSifilisGItemStateChanged(null);
        JCBHipertensionIndItemStateChanged(null);
        JCBHipotiroidismoCongItemStateChanged(null);
        m21JCBSintomticoRespItemStateChanged(null);
        JCBTuberculosisItemStateChanged(null);
        JCBLepraItemStateChanged(null);
        JCBObesidadProteicaItemStateChanged(null);
        m22JCBVctimaltratoItemStateChanged(null);
        m23JCBVctViolenciaSexItemStateChanged(null);
        JCBTransmisionSexItemStateChanged(null);
        JCBEnfMetalItemStateChanged(null);
        JCBCancerCervixItemStateChanged(null);
        JCBCancerSenoPGItemStateChanged(null);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBSifilisG.getSelectedIndex() != -1) {
            if (this.JCBHipertensionInd.getSelectedIndex() != -1) {
                if (this.JCBHipotiroidismoCong.getSelectedIndex() != -1) {
                    if (this.f7JCBSintomticoResp.getSelectedIndex() != -1) {
                        if (this.JCBLepra.getSelectedIndex() != -1) {
                            if (this.JCBObesidadProteica.getSelectedIndex() != -1) {
                                if (this.f9JCBVctimaltrato.getSelectedIndex() != -1) {
                                    if (this.f8JCBVctViolenciaSex.getSelectedIndex() != -1) {
                                        if (this.JCBEnfMetal.getSelectedIndex() != -1) {
                                            if (this.JCBCancerCervix.getSelectedIndex() != -1) {
                                                if (this.JCBCancerSenoPG.getSelectedIndex() != -1) {
                                                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                    if (n == 0) {
                                                        this.sql = "INSERT INTO `h_atencion_evaluacion_riesgo`(`IdAtencion`,`IdProfesional`,`IdEspecialidad`,IdUsuario,`SifilisG`,`HipertensionInd`,`HipotiroidismoCong`,`SintomáticoResp`,`Lepra`,`ObesidadProteica`,`Victimaltrato`,`VíctViolenciaSex`,`EnfMetal`,`CancerCervix`,`CancerSenoPG`,`UsuarioS`, Tuberculosis, TransmisionSex, FechaA)\nVALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xSifilisG + "','" + this.xHipertensionInd + "','" + this.xHipotiroidismoCong + "','" + this.f5xSintomticoResp + "','" + this.xLepra + "','" + this.xObesidadProteica + "','" + this.xVictimaltrato + "','" + this.f6xVctViolenciaSex + "','" + this.xEnfMetal + "','" + this.xCancerCervix + "','" + this.xCancerSenoPG + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xTuberculosis + "','" + this.xTransmisionsex + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')";
                                                        this.xconsulta.ejecutarSQL(this.sql);
                                                        this.xconsulta.cerrarConexionBd();
                                                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                                    }
                                                    mNuevo();
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JCBCancerSenoPG.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JCBCancerCervix.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JCBEnfMetal.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.f8JCBVctViolenciaSex.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.f9JCBVctimaltrato.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBObesidadProteica.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBLepra.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.f7JCBSintomticoResp.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBHipotiroidismoCong.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBHipertensionInd.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBSifilisG.requestFocus();
    }

    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "FechaA", "Profesional", "Especialidad", "IdUsuario", "SifilisG", "HipertensionInd", "HipotiroidismoCong", "SintomáticoResp", "Tuberculosis", "Lepra", "ObesidadProteica", "Victimaltrato", "VíctViolenciaSex", "TransmisionSex", "EnfMetal", "CancerCervix", "CancerSenoPG", "Estado"}) { // from class: Historia.JPAEvaluacionRiesgo.16
            Class[] types = {Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloTabla();
            String sql = "SELECT `h_atencion_evaluacion_riesgo`.`Id`, `h_atencion_evaluacion_riesgo`.`FechaA`, `persona`.`NUsuario` AS `Profesional`, `g_especialidad`.`Nbre` AS `Especialidad`\n, `h_atencion_evaluacion_riesgo`.`IdUsuario`, `h_atencion_evaluacion_riesgo`.`SifilisG`, `h_atencion_evaluacion_riesgo`.`HipertensionInd`, `h_atencion_evaluacion_riesgo`.`HipotiroidismoCong`\n, `h_atencion_evaluacion_riesgo`.`SintomáticoResp`, `h_atencion_evaluacion_riesgo`.`Tuberculosis`, `h_atencion_evaluacion_riesgo`.`Lepra`, `h_atencion_evaluacion_riesgo`.`ObesidadProteica`\n, `h_atencion_evaluacion_riesgo`.`Victimaltrato`, `h_atencion_evaluacion_riesgo`.`VíctViolenciaSex`, `h_atencion_evaluacion_riesgo`.`TransmisionSex`\n, `h_atencion_evaluacion_riesgo`.`EnfMetal`, `h_atencion_evaluacion_riesgo`.`CancerCervix`, `h_atencion_evaluacion_riesgo`.`CancerSenoPG`, `h_atencion_evaluacion_riesgo`.`Estado`\n FROM `g_especialidad` INNER JOIN `h_atencion_evaluacion_riesgo` ON (`g_especialidad`.`Id` = `h_atencion_evaluacion_riesgo`.`IdEspecialidad`) INNER JOIN `persona` \nON (`persona`.`Id_persona` = `h_atencion_evaluacion_riesgo`.`IdProfesional`) WHERE (`h_atencion_evaluacion_riesgo`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_atencion_evaluacion_riesgo`.`Estado` =1)\nORDER BY `h_atencion_evaluacion_riesgo`.`FechaA` ASC;";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(8)), n, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(9)), n, 8);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(10)), n, 9);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(11)), n, 10);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(12)), n, 11);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(13)), n, 12);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(14)), n, 13);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(15)), n, 14);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(16)), n, 15);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(17)), n, 16);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(18)), n, 17);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(19)), n, 18);
                    n++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAEvaluacionRiesgo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
